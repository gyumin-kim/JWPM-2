# Github 특강

## TIL

- StackOverflow 코드 따라치기
- Codecademy, CodaWarz, HackerRank 등의 튜토리얼을 따라치기
- 튜토리얼 변형, 번역
- 책에서 공부한 코드
- 스프린트 참여: 오픈소스 기여  
  문서 번역, 오탈자 찾기 등 초보자가 기여할 수 있는 것도 많다. (Good for beginner?)
- 정적 블로그 운영  
  자주 commit, Git에 익숙해지기  
  Jekyll 정적 블로그 만들기 튜토리얼 참조



## Git

local ---> GitHub: `git push -u origin master`  
GitHub ---> local: `git pull --rebase origin master`



## 협업

1. upstream에서 fork 해온다
2. `git clone (fork해 온 repo의 주소: SSH 사용)` 으로 로컬에 불러오기
3. 해당 디렉토리로 이동 후 `git remote add upstream (upstream의 주소: SSH)`
4. `git remote -v` 해보면, upstream이 추가되어 있음
5. `git pull --rebase upstream master`로 upstream의 변경사항을 내 로컬에 반영
6. `git push -u origin master`로 fork한 내 repo에도 반영
7. PR은 내 repo에서 'Pull Request' 메뉴 —> 'new pull request'  
   'Resolve Conflicts'  
   ![image-20180905213231323](/var/folders/5j/nllrfgtn5813pdswn9fryffw0000gn/T/abnerworks.Typora/image-20180905213231323.png)