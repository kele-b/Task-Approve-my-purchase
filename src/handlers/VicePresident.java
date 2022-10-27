package handlers;

import common.Type;


/**
 * //TODO - Implement approval implementation for VicePresident level
 */
public class VicePresident extends Approver{
    @Override
    public void approve(int id, double cost, Type type) {
        if (canApprove(cost, type)) {
            System.out.println("VicePresident approved purchase with id " + id + " that costs " + cost);
            return;
        }

        System.out.println("Purchase with id " + id + " needs approval from higher position than VicePresident.");
        next.approve(id, cost, type);
    }

    @Override
    protected boolean canApprove(double cost, Type type) {
        return switch (type){
            case CONSUMABLES -> cost <= 700;
            case CLERICAL -> cost <= 1500;
            case GADGETS -> cost <= 2000;
            case GAMING -> cost <= 4500;
            case PC -> cost <= 6500;
        };
    }
}
