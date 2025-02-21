package com.woowacourse.momo.domain.availabledate;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import com.woowacourse.momo.domain.meeting.Meeting;
import com.woowacourse.momo.exception.MomoException;
import com.woowacourse.momo.exception.code.AvailableDateErrorCode;
import com.woowacourse.momo.fixture.MeetingFixture;
import java.time.LocalDate;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AvailableDatesTest {

    @DisplayName("가능한 시간의 값이 중복이면 예외가 발생한다.")
    @Test
    void throwExceptionWhenDuplicatedDate() {
        // given
        Meeting meeting = MeetingFixture.GAME.create();
        LocalDate date = LocalDate.of(2024, 7, 24);
        List<LocalDate> dates = List.of(date, date);

        // when then
        assertThatThrownBy(() -> new AvailableDates(dates, meeting))
                .isInstanceOf(MomoException.class)
                .hasMessage(AvailableDateErrorCode.DUPLICATED_DATE.message());
    }

    @DisplayName("가능한 시간이 중복이 아니면 예외가 발생하지 않는다.")
    @Test
    void createAvailableDates() {
        // given
        Meeting meeting = MeetingFixture.GAME.create();
        LocalDate date1 = LocalDate.of(2024, 7, 24);
        LocalDate date2 = LocalDate.of(2024, 8, 25);
        List<LocalDate> dates = List.of(date1, date2);

        // when then
        assertThatCode(() -> new AvailableDates(dates, meeting))
                .doesNotThrowAnyException();
    }
}
