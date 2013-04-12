/**
 * Created with IntelliJ IDEA.
 * User: caiwm
 * Date: 13-4-10
 * Time: 下午11:50
 * To change this template use File | Settings | File Templates.
 */

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



/**
 * Display:block
 * duration:500ms
 * @param div_id
 * @param callBack
 */
function fadeInDiv_500(div_id, callBack){
    var $div = $("#" + div_id);
    $div.show(500,callBack);
}

/**
 * Display:block
 * duration:500ms
 * @param div_id
 * @param callBack
 */
function fadeInDiv_200(div_id, callBack){
    var $div = $("#" + div_id);
    $div.show(200,callBack);
}

/**
 * Display:block
 * duration:500ms
 * @param div_id
 * @param callBack
 */
function fadeInDiv_800(div_id, callBack){
    var $div = $("#" + div_id);
    $div.show(800,callBack);
}

function onBlurToggleClass($obj, classes) {
    $obj.each(function () {
        $(this).mouseover(function () {
            $(this).toggleClass(classes);
        }).mouseout(function () {
                $(this).toggleClass(classes);
        });
    });
}