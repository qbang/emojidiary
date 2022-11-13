# Overview

- 프로젝트 소개: 감정을 표현하기 위해 표정 이모티콘을 사용하며, 부가적인 텍스트는 선택사항으로 최대한 간단하게 감정을 기록할 수 있는 서비스입니다.
- 참여인원: 3명
- 시연영상: [https://youtu.be/KIvKvius5Dg](https://youtu.be/KIvKvius5Dg)
- 사용기술: `Spring Framework` `JSP` `MySQL` `MyBatis`

# Preview
|화면 이름|설명|화면 이미지|
|-|-|-|
|메인 화면|표정 이모티콘들이 표시된 달력을 확인 할 수 있습니다. 상단 좌우 화살표 아이콘을 통해 달을 변경할 수 있습니다.(좌: 이전 달, 우: 다음 달)|![Untitled](https://user-images.githubusercontent.com/41017076/201528794-8c8c70b1-faa8-4478-8d2f-b38d5431fa7e.png)|
|메모화면|이미 기분을 선택 했어도 표정 이모티콘을 변경할 수 있으며, 해당 표정에 대한 간단한 메모를 적을 수 있습니다.|![Untitled 2](https://user-images.githubusercontent.com/41017076/201528833-8c0b4928-9518-413d-a132-c517aa45068d.png)|

# Feature
### 표정 기록 기능
- 표정 이모티콘은 '매우 행복', '행복', '그저 그럼', '슬픔', '화남'으로 총 5가지가 있습니다.
- 달력에서 날짜를 선택하고, 표정 이모티콘과 함께 간단한 메모를 기록할 수 있으며, 아무런 메모를 입력하지 않으면 기본값으로 '끄적끄적...'이 저장됩니다.
- 이미 기록이 있어도, 표정을 다시 선택하면 표정과 메모를 변경할 수 있습니다.
- 그동안 기록했던 기분들을 달력을 통해 한 눈에 볼 수 있고, 자유롭게 월을 변경하여 보고 싶은 기록을 볼 수 있습니다.

# 담당 역할
- 달력 기능 개발
- 회원 관리, 글쓰기 등 게시판 기능 개발
- 데이터베이스 설계 및 구축

# Other libraries
### Semantic UI & Bootstrap
- https://semantic-ui.com/
- https://getbootstrap.kr/
- View의 stylesheet로 활용하였습니다.
