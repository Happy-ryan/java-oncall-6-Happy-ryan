### 미션 해결 전략
#### 1. 본인이 이해하고 구현한 내용에 기반해 '다른 근무자와 순서를 바꿔야 하는 경우'를 자신만의 예시를 들어 설명하세요. (필수)

- **Case1. 특정 x월의 1일 월요일 평일 근무자가 '성한'**
  - *Case1-1.* 2일 화요일이 평일인 경우 평일 순번상 연속 이틀 근무 불가
  - *Case1-2.* 2일 화요일이 휴무일 경우 휴무일 순번상 '성한'이 연속해서 근무하는 문제 발생.

- **Case2. 특정 x월의 1일 금요일 평일 근무자가 '성한'**
  - *Case2-1.* 2일(다음 날)이 주말인 경우 휴무일 순번상 '성한'이 연속해서 근무하는 문제 발생.

- **Case3. 특정 x월의 1일 토요일 근무자가 '성한'**
  - *Case3-1.* 2일(다음 날)도 주말이므로 휴일 순번상 연속 이틀 근무 불가

- **Case4. 특정 x월의 1일 일요일 근무자가 '성한'**
  - *Case4-1.* 2일(다음 날)이 평일일 때 평일 순번상 '성한'이 연속해서 근무하는 문제 발생.
  - *Case4-2.* 2일(다음 날)이 휴무일일 경우 휴무일 순번상 연속 이틀 근무 불가

- **정리**
  1. **월 ~ 목요일:** 다음 날 휴무일이 아닌 경우 문제 발생하지 않음 / ⚠️다음 날이 휴무일일 경우 문제 발생 가능
  2. **금요일:** ⚠️다음 날이 주말이므로 문제 발생 가능
  3. **토요일:** 다음 날이 주말이므로 어떤 경우에도 문제 발생하지 않는다.
  4. **일요일:** ⚠️다음 날이 평일이므로 문제 발생 가능 / 다음 날이 휴무일일 경우 문제 발생하지 않음.

#### 2. 요구사항에서 제시한 앞의 날짜부터 순서를 변경하는 방법 외에 다른 방법이 있다면 어떤 방식이 있는지, 이 방법은 기존에 제시된 방식과 비교해 어떤 차이가 있는지 설명하세요. (선택)
