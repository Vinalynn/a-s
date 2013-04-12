/**
 * Created with IntelliJ IDEA.
 * User: caiwm
 * Date: 13-4-8
 * Time: 下午12:38
 * To change this template use File | Settings | File Templates.
 */

/**
 * init
 */
$(function(){
    //slide index page pic
    init_slide_index_pic();
    //zoomOneElement();
});

function init_slide_index_pic(){
    //$('#slides_container').fadeIn(2000);
    $('#slides').slidesjs({
        width: 800,
        height:450,
        play: {
            active: true,
            auto: true,
            interval: 4000,
            swap: true
        }
    });
}

function zoomOneElement(){
    $("#zoom_1").zoomTarget()
}

/* object to string */
function obj2str(o){
    var r = [], i, j = 0, len;
    if(o == null) {
        return o;
    }
    if(typeof o == 'string'){
        return '"'+o+'"';
    }
    if(typeof o == 'object'){
        if(!o.sort){
            r[j++]='{';
            for(i in o){
                r[j++]= '"';
                r[j++]= i;
                r[j++]= '":';
                r[j++]= obj2str(o[i]);
                r[j++]= ',';
            }
            //可能的空对象
            //r[r[j-1] == '{' ? j:j-1]='}';
            r[j-1] = '}';
        }else{
            r[j++]='[';
            for(i =0, len = o.length;i < len; ++i){
                r[j++] = obj2str(o[i]);
                r[j++] = ',';
            }
            //可能的空数组
            r[len==0 ? j:j-1]=']';
        }
        return r.join('');
    }
    return o.toString();
}