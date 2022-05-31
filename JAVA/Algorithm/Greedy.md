# 그리디 알고리즘(Greedy Algorithm)
___
## Greedy Algorithm의 정의
Greedy는 '탐욕스러운, 욕심 많은' 이라는 뜻을 가지고 있다. 즉, Greedy Algorithm은 문제를 해결하는 과정에서 `매 순간 최적이라 생각되는 해답(locally optimal solution)을 찾으며, 이를 토대로 최종 문제의 해답(globally optimal solution)에 도달하는 문제 해결 방식`이다.

Greedy Algorithm으로 문제를 해결하는 방은 다음과 같이 세 단계로 구분할 수 있다.

>1. 선택 절차(Selection Procedure) : 현재의 상태에서 최적의 해답을 선택한다.
>2. 적절성 검사(Feasibility Check) : 선택된 해가 문제의 조건을 만족하는지 검사한다.
>3. 해답 검사(Solution Check) : 원래의 문제가 해결되었는지 검사하고, 해결되지 않았다면 `선택 절차`로 돌아가 위의 과정을 반복한다.


