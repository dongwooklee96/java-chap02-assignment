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

```
  public class Crypto {

    public encryption(...) {
      if ("AES".equals(type)) {
         this.aes256(file);
      }
      //     ....
    }

    public void aes256(File file) {
        // aes256 알고리즘을 수행한다.
        System.out.println("aes256 알고리즘을 수행한다.");
    }

    public void bcrypt(File file) {
        // bcrypt 알고리즘을 수행한다.
        System.out.println("bcrypt 알고리즘을 수행한다.");
    }
}
```

위와 같은 코드를 작성하였을 때는 새로운 요구사항이 추가되었다고 가정하면, Encryptors 내에 if 문이 추가될 것이다.
또한 Crypto 클래스 내에도 새로운 메서드가 추가 되어, 새로운 기능이 추가될 때마다 클래스를 수정 해야한다.

```
public interface Encryptors {
    File encryption(File target);
}
```

```
public class AES256Encryptors implements Encryptors {
    @Override
    public File encryption(File target) {
        // AES로 암호화 한다.
        System.out.println("AES로 암호화");
        return null;
    }
}
```

따라서 다음과 같이 인터페이스를 만들어 추상화 시킨 다음에, 구체적인 구현체로 이를 구현하는 것이 더 좋을 것이다.



```
package com.dongwook.encrypt;

import java.io.File;

public class Saving implements SaveLocalable, Uploadable {

    public void saveFileToLocal(String path, File file) {

```

또한 `Saving` 클래스는 새로운 저장 방식에 대한 요구사항이 추가되면 인터페이스 구현이 추가되어서 구현이 더해지는 모습이다.

저장 방식에 대한 타입이 10개 정도로 늘어났다고 생각을 해보면, 구현하는 인터페이스만 하더라도 10개이다.
따라서 담당하는 역할이 10개가 되는데, 이러한 구조는 사용성에 있어서 취약한 구조이다.

```
   final File file = new File("");
   Encryptors encryptors = new Encryptors(new Crypto(), new Saving());
   encryptors.encryption(file, "AES").saveFileToLocal("/usr/tmp");
   encryptors.encryption(file, "BCRYPT").uploadFileToServer("https://client.io/api/v1/uplodas");

   // AES로 암호화 하고 Client에서 보내는 요청 값에 따라 파일 저장을 할 지 업로드를 할 지 선택한다는 코드를 짜보면
   if(파일에 저장) {
      encryptors.encryption(file, "BCRYPT").saveFileToLocal(...)
   } else if(업로드) {
      encryptors.encryption(file, "BCRYPT").uploadFileToServer("https://client.io/api/v1/uplodas");
   }

```
