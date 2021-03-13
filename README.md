## Chapter 10 (객체지향)

객체지향의 특징 3가지와 (캡슐화, 상속, 다형성) 객체지향 5원칙에 대해서 배우게 되었습니다.

## 과제
파일 암호화 모듈의 단계별 코드 작성  (실제 알고리즘을 구현할 필요는 없음. 로직 구현부를 주석으로 대체함)

#### (1) 해당 모듈을 사용하는 클라이언트는 암호화 된 파일을 지정된 위치 (/usr/tmp)에 저장하고 싶어한다.

```
class Encryptors {
  public void encryption(File) {
    // AES256 암호화를 수행한다
    // 암호화 결과를 /usr/tmp에 저장한다
  }
}
```

#### (2) 해당 Class를 사용하는 클라이언트가 BCrypt 암호화도 지원하도록 요구한다.
#### (3) 해당 Class를 사용하는 클라이언트가 때에 따라 물리적 위치에 저장하거나 https://client.io/api/v1/uplodas API를 통해 업로드 하고 싶어한다.

**(1) AES 암호화 알고리즘을 사용하여 암호화 하고 /usr/tmp에 저장하는 코드**

```
class Encryptors {
  public void encryption(File file) {
    // AES256 암호화를 수행한다
    // 암호화 결과를 /usr/tmp에 저장한다
  }
}
 
class Main {
  public static void main(String args[]) {
    final File file = new File();
    new Encryptors(file);
  }
}
```

**(2) BCrypt도 지원하는 코드**
```
class Encryptors {
  public void encryption(File file, String type) {
    if("AES".equals(type) {
      // AES256 암호화를 수행한다
      // 암호화 결과를 /usr/tmp에 저장한다
    } else if("BCRYPT".equals(type)){
      // ...
    }
  }
}
 
class Main {
  public static void main(String args[]) {
    final File file = new File();
    new Encryptors(file, "AES");
 
    new Encryptors(file, "BCRYPT");
  }
}
```

## 피드백


