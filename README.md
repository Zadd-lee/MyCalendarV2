# 캘린더 V2

## API 명세
### 일정
#### 등록

- Method : POST
- URI:/event
- Request
    - PathVariable : 없음
    - RequestBody :

      |   | 이름      | 타입     | 필수여부 | 설명       |
      |---|---------| ------ |------|----------|
      | 1 | title   | String | 필수   | 일정 제목    |
      | 2 | contexts | String | 선택   | 일정 세부 내용 |
      | 3 | userName | String | 필수   | 사용자 이름   |


- Response

    |   | 이름       | 타입     | 설명       |
    |---|----------|--------|----------|
  | 1 | id       | Long   | 일정 식별자   |
  | 2 | title    | String | 일정 제목    |
    | 2 | contexts | String | 일정 세부 내용 |
    | 3 | userName | String | 사용자 이름   |

      


#### 단건 조회

- Method : GET
- URI:/event/{id}
- Request
    - PathVariable :

      |     | 이름 | 타입     | 필수여부 | 설명     |
      | --- |----|--------|------| ------ |
      | 1   | id | String | 필수   | 일정 식별자 |
    - RequestBody : 없음
- Response

  |   | 이름       | 타입     | 설명       |
      |---|----------|--------|----------|
  | 1 | id       | Long   | 일정 식별자   |
  | 2 | title    | String | 일정 제목    |
  | 2 | contexts | String | 일정 세부 내용 |
  | 3 | userName | String | 사용자 이름   |


#### 삭제

- Method : POST
- URI:/event/{id}
- Request
    - PathVariable :

      |     | 이름  | 타입  | 필수여부 | 설명     |
                  | --- | --- |-----| ---- | ------ |
      | 1   | id  | int | 필수   | 일정 식별자 |

    - RequestBody :

      |     | 이름       | 타입     | 필수여부 | 설명      |
                  | --- | -------- | ------ | ---- | ------- |
      | 1   | password | String | 필수   | 일정 비밀번호 |

- Response
  200 ok

#### 페이징 조회

- Method : GET
- URI:/event
- Request
    - PathVariable :

      |   | 이름       | 타입  | 필수여부 | 설명      |
                  |---|----------|-----| ---- |---------|
      | 1 | page     | int | 필수   | 페이지 번호  |
      | 2 | pageSize | int | 필수   | 페이지 사이즈 |

    - RequestBody : 없음

- Response

  |   | 이름(depth 1) | 이름 (Depth 2) | 타입    | 설명      |
        |---|-------------|--------------|-------|---------|
  | 1 | content     |              | List  | 일정 리스트  |
  | 2 |             |id       | Long  | 일정 식별자   |
  | 3 |             |title    | String | 일정 제목    |
  | 4 |             |contexts | String | 일정 세부 내용 |
  | 5 |             |userName | String | 사용자 이름   |


### 사용자
#### 등록

- Method : POST
- URI:/user
- Request
    - PathVariable : 없음
    - RequestBody :

      |     | 이름       | 타입   | 필수여부 | 설명      |
                              | --- |----------|------|------|---------|
      | 1   | name     | String | 필수   | 사용자 식별자 |
      | 2   | email    | String | 필수   | 사용자 식별자 |
      | 3   | password | String | 필수   | 사용자 식별자 |

- Response

  |   | 이름       | 타입     | 설명       |
      |---|----------|--------|----------|
  | 1 | id       | Long   | 일정 식별자   |
  | 2 | title    | String | 일정 제목    |
  | 2 | contexts | String | 일정 세부 내용 |
  | 3 | userName | String | 사용자 이름   |





#### 단건 조회

- Method : GET
- URI:/user/{id}
- Request
    - PathVariable :

    - RequestBody : 없음
- Response

  |     | 이름 | 타입   | 필수여부 | 설명      |
  | --- |----|------|------|---------|
  | 1   | id | Long | 필수   | 사용자 식별자 |


#### 삭제

- Method : DELETE
- URI:/user/{id}
- Request
    - PathVariable :

  |     | 이름 | 타입   | 필수여부 | 설명      |
    | --- |----|------|------|---------|
  | 1   | id | Long | 필수   | 사용자 식별자 |
    - RequestBody :

      |     | 이름       | 타입     | 필수여부 | 설명       |
                        | --- | -------- | ------ | ---- |----------|
      | 1   | password | String | 필수   | 사용자 비밀번호 |

- Response
  200 ok
### 사용자
#### 로그인

- Method : POST
- URI:/login
- Request
    - PathVariable : 없음
    - RequestBody :

      |   | 이름       | 타입   | 필수여부 | 설명   |
                              |---|----------|------|------|------|
      | 1 | email    | String | 필수   | 이메일  |
      | 2 | password | String | 필수   | 비밀번호 |

- Response
없음





#### 로그아웃

- Method : GET
- URI:/logout
- Request
    - PathVariable :없음
    - RequestBody : 없음
- Response : 없음


#### 회원가입

- Method : POST
- URI:/signUp
- Request
    - PathVariable : 없음
    - RequestBody :

      |     | 이름       | 타입   | 필수여부 | 설명      |
                                    | --- |----------|------|------|---------|
      | 1   | name     | String | 필수   | 사용자 식별자 |
      | 2   | email    | String | 필수   | 사용자 식별자 |
      | 3   | password | String | 필수   | 사용자 식별자 |

- Response

  |   | 이름       | 타입     | 설명       |
        |---|----------|--------|----------|
  | 1 | id       | Long   | 일정 식별자   |
  | 2 | title    | String | 일정 제목    |
  | 2 | contexts | String | 일정 세부 내용 |
  | 3 | userName | String | 사용자 이름   |


### 공통 에러코드

| 에러 코드 |
|-------|
| 500   |




## ERD
![img.png](img.png)