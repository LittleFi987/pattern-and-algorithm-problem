package memento;

/**
 * @author chenhao.ych
 * @date 2018-07-14
 */
public class Client {

    public static void main(String[] args) {
        Calculator calculator = new CalculatorImpl();
        calculator.setFirstNumber(12);
        calculator.setSecondNumber(20);
        System.out.println(calculator.getCalculationResult());

        PreviousCalculationToCareTaker memento = calculator.backupLastCalculation();
        calculator.setFirstNumber(17);
        calculator.setSecondNumber(13);

        System.out.println(calculator.getCalculationResult());

        calculator.restorePreviousCalculation(memento);
        System.out.println(calculator.getCalculationResult());

    }

}
