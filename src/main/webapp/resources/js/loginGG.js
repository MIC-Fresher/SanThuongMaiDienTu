var emailuser;
var phone;
var name;
var request;

function onSuccess(googleUser) {
    profile = googleUser.getBasicProfile();
    gapi.client.load('plus', 'v1', function () {
        request = gapi.client.plus.people.get({
            'userId': 'me'
        });
        //Display the user details
        request.execute(function (resp) {
            emailuser = resp.emails[0].value;
            name = resp.name.givenName;
            $("#test").val("dang nhap thanh cong");
            $("#email").val(emailuser);
            $("#name").val(name);
            var profileHTML = '<div class="profile"><div class="head">Welcome ' + resp.name.givenName + '! <a href="javascript:void(0);" onclick="signOut();">Sign out</a></div>';

            $('.userContent').html(profileHTML);
            $('#gSignIn').slideUp('slow');
        });
    });
}
function onFailure(error) {
    alert(error);
}
function renderButton() {
    gapi.signin2.render('gSignIn', {
        'scope': 'profile email',
        'width': 240,
        'height': 50,
        'longtitle': true,
        'theme': 'dark',
        'onsuccess': onSuccess,
        'onfailure': onFailure
    });
}
function signOut() {
    var auth2 = gapi.auth2.getAuthInstance();
    auth2.signOut().then(function () {
        $('.userContent').html('');
        emailuser = '';
        name = '';
        request=null;
        $("#test").val("dang nhap that bai");
        $("#email").val(emailuser);
        $("#name").val(name);
        $('#gSignIn').slideDown('slow');
    });
}


function checkContact()
{
    phone = $("#contact\\:phone").val();
    emailuser = $("#contact\\:email").val();
    if (request==null)
    {
        return false;
    } else
    {
        return true;
    }
}

function validateContentPhone() {
    

    if ((phone.length < 10 || phone.length >= 12) || isNaN(phone)) {

        return false;
    } else {

        return true;
    }
}
