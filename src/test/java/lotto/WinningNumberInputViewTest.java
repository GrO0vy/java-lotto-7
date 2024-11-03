package lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.view.WinningNumberInputView;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinningNumberInputViewTest {
    // 당첨 번호 입력 클래스 ( WinningNumberValidator + WinningNumberInputView ) 테스트

    @DisplayName("[WinningNumberInputViewTest] 당첨 번호에 숫자 외의 값이 입력되면 예외가 발생한다")
    @ParameterizedTest
    @ValueSource(strings = {"asd", ",123", "12 12432", "@$%#!", "123@$12,./"})
    void 당첨_번호에_숫자_외의_값이_입력되면_예외가_발생한다(String input){
        System.setIn(userInput(input));

        assertThatThrownBy(() -> new WinningNumberInputView().input())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("[WinningNumberInputViewTest] 당첨 번호에 정수 범위를 벗어난 값을 입력하면 예외가 발생한다")
    @ParameterizedTest
    @ValueSource(strings = {"990909999999", "2147483648", "1111111111111111111", "9999999999999999"})
    void 당첨_번호에_정수_범위를_벗어난_값을_입력하면_예외가_발생한다(String input){
        System.setIn(userInput(input));

        assertThatThrownBy(() -> new WinningNumberInputView().input())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @AfterEach
    void closeInputStream(){
        Console.close();
    }

    private InputStream userInput(String input){
        return new ByteArrayInputStream(input.getBytes());
    }
}
