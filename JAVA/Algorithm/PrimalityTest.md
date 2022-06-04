# 소수 판별법(Primality Test)
___

## 1. N보다 작은 자연수들로 모두 나눠본다.
가장 기본적인 방법이다. 임의의 수 N이 1과 N을 제외한 다른 약수를 가지지 않는다면, 그 수를 `소수`라 할 수 있다.
바로 코드를 보자.
```
// 소수 판별 메서드

public static void isPrime(int N) {

    // 0과 1은 소수가 아니다.
    if(N < 2) {
        System.out.println("소수가 아닙니다.");
        return;
    }
    
    // 2는 소수다
    if (N == 2) {
        System.out.println("소수입니다.");
        return;
    }
    
    for (int i = 2; i < N; i++) {
        
        // 소수가 아닐 경우
        if(N % i == 0) {
            System.out.println("소수가 아닙니다.");
            return;
        }
    }
    
    // 위 반복문에서 약수를 가지고 있지 않는 경우 소수다.
    System.out.println("소수입니다.");
    return;
}
```
2 이상 N 미만의 수 중에 나누어 떨어지는 수가 존재한다면 소수가 아님을 이용하였다.
또한, 위 알고리즘의 시간복잡도는 N 이하의 수를 모두 검사하므로 `O(N)`이다.

<br>

## 2. √N 이하의 자연수들로 모두 나눠본다.
임의의 자연수 N이 있다고 가정해볼 때, `p x q = N` 을 만족할 때 우리는 아래와 같은 부등식을 완성할 수 있다.  

`(1 <= p, q <= N )`

예를 들어 N = 18 이라 가정했을 때, 아래와 같이 두 수의 곱으로 표현할 수 있다.
```
1 x 18
2 x 9
3 x 6
6 x 3
9 x 2
18 x 1
```

여기서 우리는 만약 p가 증가한다면 자연스럽게 q가 감소한다는 사실을 알 수 있다. 그리고 p와 q는 N의 약수이기 때문에 결국 N을 임의의 수로 나누었을 때, 그 값은 `√N 보다 반드시 작거나 크다`.
즉, √N 이하의 자연수 중에 나누어 떨어지는 수가 있다면, 이는 1과 N을 제외한 다른 자연수가 N의 약수라는 의미이므로 소수가 아니게 된다.

아래의 코드를 보자. 참고로 이 코드의 시간복잡도는 √N 이하의 수까지 모든 수를 검사하므로 `O(√N)`이다. 
```
public static void isPrime(int N) {

    // 0 과 1 은 소수가 아니다
    if(N < 2) {
        System.out.print("소수가 아닙니다");
        return;
    }
    
    // 2 는 소수다
    if(N == 2) {
        System.out.print("소수입니다");
        return;
    }
    
    // 제곱근 함수 : Math.sqrt()
    for(int i = 2; i <= Math.sqrt(N); i++) {
    
        // 소수가 아닐경우
        if(N % i == 0) {
            System.out.print("소수가 아닙니다");
            return;
        }
    }
    
    // 위 반복문에서 약수를 가지고 있지 않는 경우 소수다.
    System.out.print("소수입니다");
    return;
}
```

<br>

## 3. 에라토스테네스의 체(Sieve of Eratosthenes)
N 이하의 자연수 중에서 소수를 구하는 가장 대표적인 방법이다.  
**"k = 2부터 √N 이하까지 반복하여 자연수들 중 k를 제외한 k의 배수들을 제외시킨다."**

이해가 되지 않는다면 아래의 그림을 보자.

![](png/Sieve_of_Eratosthenes_animation.gif)
[#Wikipedia][link1]

[link1]: https://ko.wikipedia.org/wiki/%EC%97%90%EB%9D%BC%ED%86%A0%EC%8A%A4%ED%85%8C%EB%84%A4%EC%8A%A4%EC%9D%98_%EC%B2%B4#%EC%97%90%EB%9D%BC%ED%86%A0%EC%8A%A4%ED%85%8C%EB%84%A4%EC%8A%A4%EC%9D%98_%EC%B2%B4%EB%A5%BC_%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%B0%8D_%EC%96%B8%EC%96%B4%EB%A1%9C_%EA%B5%AC%ED%98%84

참고로 아래 코드는 `O(Nlog(logN))`의 시간복잡도를 가진다.

```
public static boolean[] prime;	// 소수를 체크할 배열

// N 이하 소수 생성 메소드 
public static void make_prime(int N) {
    
    prime = new boolean[N + 1];	// 0 ~ N

    /*
    소수가 아닌 index = true
    소수인 index = false
    */
    
    // 2 미만의 N 을 입력받으면 소수는 판별할 필요 없으므로 바로 return
    if(N < 2) {
        return;
    }
    
    prime[0] = prime[1] = true;
    
    // 제곱근 함수 : Math.sqrt()
    for(int i = 2; i <= Math.sqrt(N); i++) {
    
        // 이미 체크된 배열이면 다음 반복문으로 continue
        if(prime[i] == true) {
            continue;
        }
    
        // i 의 배수들을 걸러주기 위한 반복문
        for(int j = i * i; j < prime.length; j = j+i) {
            prime[j] = true;
        }
    }
}
```

<br>

___
### `Reference`
[Primality Test][link]

[link]: https://st-lab.tistory.com/81