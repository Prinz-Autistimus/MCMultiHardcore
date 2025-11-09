package org.PrinzAutistimus.mCMultiHardcore.GameState;

public enum GameState {
    RUNNING("running"),
    END("end");

    private String repr;

    GameState(String _repr) {
        this.repr = _repr;
    }

    @Override
    public String toString() {
        return repr;
    }

    public static GameState matchByString(String s) {
        for (GameState state : GameState.values()) {
            if (state.repr.equalsIgnoreCase(s)){
                return state;
            }
        }
        return END;
    }
}
