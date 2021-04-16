package strategry.demo.one.contextofchoice;

import strategry.demo.one.choices.IChoice;

public class Context {
    private IChoice myC;
    public void setChoice(IChoice ic) {
        myC = ic;
    }
    public void showChoice(String s1, String s2) {
        myC.myChoice(s1, s2);
    }
}
