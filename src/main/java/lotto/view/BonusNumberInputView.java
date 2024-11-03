package lotto.view;

import lotto.messages.InputMessage;
import lotto.validator.BonusNumberValidator;

public class BonusNumberInputView extends InputView{
    @Override
    protected void printInputMessage() {
        System.out.println(InputMessage.BONUS_NUMBER_INPUT_MESSAGE.getMessage());
    }

    @Override
    protected void initializeValidator() {
        validator = new BonusNumberValidator(inputValue);
    }

    @Override
    protected void validate() {
        validator.validate();
    }
}
