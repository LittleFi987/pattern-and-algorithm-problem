package memento;

/**
 * @author chenhao.ych
 * @date 2018-07-14
 */
public class PreviousCalculationImpl implements PreviousCalculationToOriginator {

    private int firstNumber;

    private int secondNumber;

    public PreviousCalculationImpl(int firstNumber, int secondNumber) {
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
    }

    @Override
    public int getFirstNumber() {
        return firstNumber;
    }

    @Override
    public int getSecondNumber() {
        return secondNumber;
    }
}
