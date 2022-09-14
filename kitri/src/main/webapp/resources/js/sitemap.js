let gnvData = JSON.parse(JSON.stringify(Sitemap));


function divsToArray(name){
    let src = document.getElementsByClassName(name);
    return Array.prototype.slice.call(src);
}

/* 모바일인지 판단 */
function isMobile(){
    let width = window.innerWidth;
    return width <= 1000 ? true : false;
}

/* 메인화면인지 판단 */
function isHome(){
    let body = document.querySelector('body');
    return body.classList.contains('main');
}

function parentToggleOn(ele){
    if(ele.parentNode.classList.contains('on')){
        ele.parentNode.classList.remove('on');
    }else{
        ele.parentNode.classList.add('on');
    }
}


/*======================== 1depth 생성 =======================*/

/* 1depth 생성기 */
const dep1Keys = function(){
    let dep01 = Object.keys(gnvData);
    return dep01;
}


/* 1depth 엘리먼트 메이커 */
function createMainDiv(text,link){
    let ele = document.createElement('div');
    ele.innerHTML = text;
    ele.addEventListener('click', function(){
        if(isMobile()){
            if(ele.parentNode.classList.contains('on')){
                ele.parentNode.classList.remove('on');
            }else{
                removeAll();
                ele.parentNode.classList.add('on');
            }
        }else {
            location.href='/sub/sub'+ link +'.php';
        }
    })
    return ele;
}
/* 1depth 만들고 넣는 함수 */
function menuAdder(target){
    for(let i = 0; i < dep1Keys().length; i++){ 
            let ind = i;
            let targetChilds = target[ind].childNodes;
            let text = gnvData[dep1Keys()[ind]].name;
            let link = Object.keys(gnvData)[ind];
            let ele = createMainDiv(text,link);
            ele.classList.add('gnv_d1');
            target[ind].insertBefore(ele, targetChilds[0]);
        }
}


/* 1depth 만들어 넣기 실행 */
function putMenuName(){
    let gnvMenu = divsToArray('gnv_menu');
    let footGnvMenu = divsToArray('footer_site_map');
    menuAdder(gnvMenu);
    menuAdder(footGnvMenu);
}



/*======================== 2depth 생성 =======================*/


/* 2depth 엘리먼트 메이커 */
function createDiv(text,link){
    let ele = document.createElement('div');
    ele.innerHTML = text;
    ele.addEventListener('click', function(){
        location.href='/sub/sub'+ link +'.php';
    })
    return ele;
}


/* 2depth 만들고 넣는 함수 */
function subMenuAdder(target){
    for(let i = 0; i < dep1Keys().length; i++){ 
        let ind = i;
        for(let j = 0; j < Object.keys(gnvData[dep1Keys()[ind]].sub).length; j++){
            let text = gnvData[dep1Keys()[ind]].sub[Object.keys(gnvData[dep1Keys()[ind]].sub)[j]].name;
            let link = Object.keys(gnvData[dep1Keys()[ind]].sub)[j];
            let ele = createDiv(text,link);
            target[i].appendChild(ele);
        }
    }
}

/* 2depth 만들어 넣기 실행 */
function subMenuAdd(){
    let menuArr = divsToArray('gnv_d2_wrap');
    let footmenuArr = divsToArray('foot_d2_wrap');
    subMenuAdder(menuArr);
    subMenuAdder(footmenuArr);
}




/*======================== 모바일 메뉴 기능 =======================*/

/* 모바일 gnv 오픈 버튼 */
function mobileMenuToggle(){
    let btn = document.querySelector('.gnv_mobile_menu_btn');
    if(btn.classList.contains('on')){
        mobileMenuClose();
        popBgMaker('off');
    }else{
        mobileMenuOpen();
        popBgMaker('on');
    }
}

/* 모바일 gnv 닫기 */
function mobileMenuClose(){
    let btn = document.querySelector('.gnv_mobile_menu_btn');
    let menuWrap = document.querySelector('.gnv_menu_wrap');
    btn.classList.remove('on');
    menuWrap.classList.remove('on');
}

/* 모바일 gnv 열기 */
function mobileMenuOpen(){
    let btn = document.querySelector('.gnv_mobile_menu_btn');
    let menuWrap = document.querySelector('.gnv_menu_wrap');
    btn.classList.add('on');
    menuWrap.classList.add('on');
}

/* 모바일 서브 메뉴 전체 닫기 기능 */
function removeAll(){
    let gnvAllArr = divsToArray('gnv_menu');
    for(let i = 0; i < gnvAllArr.length; i++){
        let ind = i;    
        gnvAllArr[ind].classList.remove('on');
    }
}

/* 반투명 배경 적용 */
function popBgMaker(s){
    let target = document.querySelector('body');
    if(s === 'on'){
        let bg = document.createElement('div');
        bg.classList.add('black_bg');
        target.appendChild(bg);
    }else{
        let ele = document.querySelector('.black_bg');
        if(ele){
            ele.remove();
        }
    }
}




/*======================== 서브페이지 탭 기능 =======================*/


function getPageNum(){
    let numSrc = document.querySelector('.pageChecker').classList;
    let sub = numSrc[1].split('_')[0];
    let dep1 = numSrc[1].split('_')[1];
    let dep2 = numSrc[1].split('_')[2];
    return [sub,dep1,dep2];
}

/* tab 엘리먼트 메이커 */
function createTab(text,link,nowPage){
    let ele = document.createElement('div');
    ele.innerHTML = text;
    if(link === nowPage) {
        ele.classList.add('now');
        ele.classList.add('sub_tab_btn');
        ele.addEventListener('click', function(){
            parentToggleOn(ele);
        });        
    }else{
        ele.classList.add('sub_tab_btn');
        ele.addEventListener('click', function(){
            location.href='/sub/sub'+ link +'.php';
        });
    }
    return ele;
}

/* tab 현재 탭 모바일용으로 맨 앞으로 옮기기 */
function moveNowTab(){
    let wrap = document.querySelector('.sub_tab');
    let tabs = divsToArray('sub_tab_btn');
    let nowTab = document.querySelector('.now');
    let position = tabs.indexOf(nowTab);
    if(isMobile()){
        wrap.insertBefore(nowTab, tabs[0]);
    }else{
        wrap.insertBefore(nowTab, tabs[getPageNum()[2]*1]);
    }
}



/* tab 만들고 넣는 함수 */
function createSubTab(target){
    const pageKey = getPageNum()[1] + '_' + "01";
    const nowPage = getPageNum()[1] + '_' + getPageNum()[2];
    const tabList = gnvData[pageKey].sub;
    const keys = Object.keys(tabList);
    for(let i = 0; i < keys.length; i++){
        let ind = i;
        let ele = createTab(tabList[keys[ind]].name, keys[ind], nowPage);
        target.appendChild(ele);
    }
}

/* tab 만들어 넣기 실행 */

function subTabAdd(){
    const wrap = document.querySelector('.sub_tab')
    createSubTab(wrap);
}

/* tab 사이즈 조정 */
function tabSizer(){
    let tabs = divsToArray('sub_tab_btn');
    let tabSize = 100/tabs.length < 50 ? 100/tabs.length : 50 ;
    if(isMobile()){
        for(let i = 0; i < tabs.length; i++){
            let ind = i;
            tabs[ind].style.width = 100 + '%';
        }
    }else{        
        for(let i = 0; i < tabs.length; i++){
            let ind = i;
            tabs[ind].style.width = tabSize + '%';
        }
    }
}






/*======================== 실행 =======================*/

function isRealResize(){
    return screen.width !== window.innerWidth ? true : false;
}


window.addEventListener('resize', function(){
    if(!isHome()){
        tabSizer();
        moveNowTab();
    }
    if(isMobile()){
        if(isRealResize()){ 
            removeAll();
        }
    }else{
        mobileMenuClose();
        popBgMaker('off');
    }
});

window.addEventListener('load', function(){
    if(!isHome()){
        subTabAdd();
        tabSizer();
        moveNowTab();
    }
    putMenuName();
    subMenuAdd();
});