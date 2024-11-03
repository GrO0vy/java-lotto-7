package lotto;

import lotto.validator.PriceValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PriceValidatorTest {
    @DisplayName("구입 금액에 숫자 외의 문자가 있으면 예외가 발생한다")
    @ParameterizedTest
    @ValueSource(strings = {"asd", ",123", "12 12432", "@$%#!", "123@$12,./"})
    void 구입_금액에_숫자_외의_문자가_있으면_예외가_발생한다(String input){
        System.out.println(input);
        assertThatThrownBy(() -> new PriceValidator(input).validate())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("음수를 입력하면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"-1", "-1000000", "-2147483648", "-3482739"})
    void 음수를_입력하면_예외가_발생한다(String input){
        assertThatThrownBy(() -> new PriceValidator(input).validate())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("정수 범위를 벗어나면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1231241242141", "999999999999999", "2147483648"})
    void 정수_범위를_벗어나면_예외가_발생한다(String input){
        assertThatThrownBy(() -> new PriceValidator(input).validate())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("천 단위 숫자가 아니면 예외가 발생한다")
    @ParameterizedTest
    @ValueSource(strings = {"10001", "25001", "2147483647", "0"})
    void 천_단위_숫자가_아니면_예외가_발생한다(String input){
        assertThatThrownBy(() -> new PriceValidator(input).validate())
                .isInstanceOf(IllegalArgumentException.class);
    }
}