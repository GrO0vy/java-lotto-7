package lotto.validator;

// 당첨 번호 검증 클래스
public class WinningNumberValidator implements Validator {
    private final String winningNumbers;

    public WinningNumberValidator(String winningNumbers){
        this.winningNumbers = winningNumbers;
    }

    @Override
    public void validate() {
        isValidatedForm();

        for(String winningNumber: winningNumbers.split(",")){
            isValueInRange(winningNumber);
        }
    }

    private void isValidatedForm(){
        if(!winningNumbers.matches("[0-9|,]+")){
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1 ~ 45 사이의 숫자와 쉼표만 입력 할 수 있습니다. (공백 없이 쉼표로만 숫자 구분)");
        }
    }

    private void isValueInRange(String winningNumber){
        try{
            int number = Integer.parseInt(winningNumber);

        }catch (Exception e){
            throw new IllegalArgumentException("[ERROR] 로또 번호는 정수 범위를 벗어 날 수 없습니다.");
        }
    }
}