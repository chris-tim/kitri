/* 플레이스홀더 JS */

$(document).ready(function () {
  $(".pl_ip").focus(function () {
    $(this).parent(".pl_wrap").addClass("on"); // class2 : 바로 윗단계 클래스
  });
  $(".pl_ip").blur(function () {
    if ($(this).val() == "") {
      // 인풋창에 글자가 없을 경우
      $(this).parent(".pl_wrap").removeClass("on"); // 부모 DIV의 on 클래스를 삭제한다.
    } else {
      // 인풋창에 글자가 있을 경우 (사실 이 부분은 없어도 무관)
      // 아무것도 하지 않음
    }
  });
});

/* 메인화면인지 판단 */
function isMain() {
  let url = window.location.href;
  return /index/.test(url + "") || /com\/$/.test(url + "");
}

function addMainClass() {
  if (isMain()) document.querySelector("body").classList.add("main");
}

window.addEventListener("load", function () {
  addMainClass();
});
