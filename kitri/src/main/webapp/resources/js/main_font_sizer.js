function getBoxWidth(){
    let box = document.querySelector('.main_service');
    let wid = box.getBoundingClientRect().width;
    return wid;
}

function serviceFontSizer(){
    let fSize = Math.floor(getBoxWidth()/10);
    if(fSize > 22){
        return 22
    }else {
        return fSize;
    }
}

function fontSizeAdd(){
    let boxSrc = document.getElementsByClassName('responsive_font');
    let boxArr = Array.prototype.slice.call(boxSrc);
    for(let i = 0; i < boxArr.length; i++){
        let ind = i;
        boxArr[ind].style.fontSize = serviceFontSizer() + 'px';
    }
}


(function(){
    fontSizeAdd()
})();

window.addEventListener('resize', function(){
    fontSizeAdd()
})