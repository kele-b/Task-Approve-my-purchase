package handlers;

import common.Type;

/**
 * //TODO - If needed, validate logic and if possible optimize code
 */
public class Manager extends Approver {
    @Override
    public void approve(int id, double cost, Type type) {
        if(!isValidParameters(id,cost,type)) {
            System.out.println("Invalid parameter in approve request!");
            return;
        }

        if (canApprove(cost, type)) {
            System.out.println("Manager approved purchase with id " + id + " that costs " + cost);
            return;
        }

        System.out.println("Purchase with id " + id + " needs approval from higher position than Manager.");
        next.approve(id, cost, type);
    }

    @Override
    protected boolean canApprove(double cost, Type type) {
        if(Type.CONSUMABLES.equals(type) && cost <= 300)
            return true;
        if (Type.CLERICAL.equals(type) && cost <= 500)
            return true;
        if(Type.GADGETS.equals(type) && cost <= 1000)
            return true;
        if(Type.GAMING.equals(type) && cost <= 3000)
            return true;
        return Type.PC.equals(type) && cost <= 5000;
    }

    //testing if all parameters are valid so program will not break if inappropriate values are passed to the method
    private boolean isValidParameters(int id, double cost, Type type){
        return id > 0 && cost > 0 && null != type;
    }


}
