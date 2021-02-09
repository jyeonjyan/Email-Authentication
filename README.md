# 이메일 인증을 통한 회원인증 서비스
## 📄 Function
> **1. 회원가입시 이메일로 인증 링크 발행**  
> **2. 해당 링크 접속시 인증여부를 "true"로 반환**  
> **3. 이메일 인증 여부가 "true"면 로그인 허용 "false"면 예외처리**

##💁🏻‍♀️ Dependency
> Lombok  
> Spring Web  
> H2 Database  
> Spring Security  
> Validation  
> Spring Data JPA  
> Java Mail Sender

## ✅ API Testing 방법
### signUp
```
localhost:8080/user/signup
```
### DB Check
```
localhost:8080/h2-console
```