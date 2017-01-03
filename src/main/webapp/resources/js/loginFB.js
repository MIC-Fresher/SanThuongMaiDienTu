

var emailuser;
var phone;
var name;
var request;


window.fbAsyncInit = function () {
    FB.init({
        appId: '972024926262936',
        xfbml: true,
        version: 'v2.8'
    });
    FB.getLoginStatus(function (response) {
        if (response.status === 'connected') {
            document.getElementById('status').innerHTML = 'We are connected.';

            //document.getElementById('login').style.visibility = 'hidden';
        } else if (response.status === 'not_authorized') {
            document.getElementById('status').innerHTML = 'We are not logged in.'
        } else {
            document.getElementById('status').innerHTML = 'You are not logged into Facebook.';
        }
    });
};

(function (d, s, id) {
    var js, fjs = d.getElementsByTagName(s)[0];
    if (d.getElementById(id)) {
        return;
    }
    js = d.createElement(s);
    js.id = id;
    js.src = "//connect.facebook.net/en_US/sdk.js";
    fjs.parentNode.insertBefore(js, fjs);
}(document, 'script', 'facebook-jssdk'));

// login with facebook with extra permissions
function login() {
    FB.login(function (response) {
        if (response.status === 'connected') {

            getInfo();
            //document.getElementById("formfb").submit();

            // document.getElementById('login').style.visibility = 'hidden';

        } else if (response.status === 'not_authorized') {
            document.getElementById('status').innerHTML = 'We are not logged in.';
        } else {
            return false;
        }
    }, {scope: 'email'});
}

// getting basic user info
function getInfo() {

    FB.api('/me', 'GET', {fields: 'first_name,last_name,name,id,email'}, function (response) {
//        document.getElementById('status').innerHTML = response.id;
//        document.getElementById('email').value = response.email;
//        document.getElementById('name').value = response.name;
//        //document.getElementById('idFB').value = response.id;

        window.location.href = "checkloginFB.html?name="+response.name+"&id="+response.id;;

    });
}
function signOut() {
    var auth2 = gapi.auth2.getAuthInstance();
    auth2.signOut().then(function () {
        $('.userContent').html('');
        emailuser = '';
        name = '';
        request = null;
        $("#test").val("dang nhap that bai");
        $("#email").val(emailuser);
        $("#name").val(name);
        $('#gSignIn').slideDown('slow');
    });
}


function checkContact()
{

    emailuser = $("#formfb\\:email").val();
    if (emailuser === "")
    {
        return false;
    } else
    {
        return true;
    }
}

