package memento;

/**
 * @author chenhao.ych
 * @date 2018-07-14
 */
public interface Calculator {

    PreviousCalculationToCareTaker backupLastCalculation();

    void restorePreviousCalculation(PreviousCalculationToCareTaker memento);

    int getCalculationResult();

    void setFirstNumber(int firstNumber);

    void setSecondNumber(int secondNumber);
}
