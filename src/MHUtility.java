public class MHUtility implements Utility{

    public MHUtility() {}

    @Override
    public boolean checkValidUserResponse(String userResponse) {
        return (userResponse.equals("w") || userResponse.equals("a") || userResponse.equals("s") || userResponse.equals("d") || userResponse.equals("q") || userResponse.equals("i") || userResponse.equals("m") || userResponse.equals("view map") || userResponse.contains(" inventory") || userResponse.contains(" drink ") || userResponse.contains("hero ") || userResponse.equals("regenerate map") || userResponse.contains(" change "));
    }

    public boolean checkIsNumber(String str) {
        try {
            int num = Integer.parseInt(str);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
}
