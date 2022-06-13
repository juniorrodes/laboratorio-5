package controllers;

import java.util.ArrayList;
import java.util.List;

public class LostCallsController {

    ArrayList<String> lostCalls;

    public LostCallsController() {
        this.lostCalls = new ArrayList<>();
    }

    public void registerLostCall(String number) {
        lostCalls.add(number);
    }

    public List<String> getLostCalls() {
        return lostCalls;
    }

    public boolean deleteCalls() {
        if (!lostCalls.isEmpty()) {
            lostCalls.clear();
            return true;
        }
        return false;
    }
}
