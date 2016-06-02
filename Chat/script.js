userName ="";
var taskList = [];

window.onload = function() {
    document.getElementById("usermsg").addEventListener("keydown", function(e) {
        if (e.keyCode == 13) {
            send();
        }
    });
    document.getElementById("ulogin").addEventListener("keydown", function(e) {
        if (e.keyCode == 13) {
            login();
        }
    });
    document.addEventListener("keydown", function(e) {
        if (e.keyCode == 46 && e.shiftKey) {
            deleteMessage();
        }
    });
}

function login() {
    userName = document.getElementById('ulogin').value;
    document.getElementById('ulogin').value = "";
    document.getElementById('welcome').textContent = "Welcome, " + userName;
}

 function logout() {
    userName = "";
    document.getElementById('welcome').textContent = "Welcome";
}

function guid() {
  function s4() {
    return Math.floor((1 + Math.random()) * 0x10000)
      .toString(16)
      .substring(1);
  }
  return s4() + s4() + '-' + s4() + '-' + s4() + '-' +
    s4() + '-' + s4() + s4() + s4();
}

function send(){
    if (userName != "") {
        var message = document.getElementById('usermsg').value;
        document.getElementById('usermsg').value = "";
        var now = new Date();
        var temp = now.getMonth() + 1;
        var time = now.getFullYear() + "." +
        temp +"." + now.getDate() + " " + now.getHours() + ":" + now.getMinutes() + ":" + now.getSeconds();
        sendWithParams(userName, message, time);
    }else{
        alert("You must login!!");
        document.getElementById('usermsg').value = "";
    }
}

function sendWithParams(author, text, time){
    
    var mycheckbox = document.createElement('input');
    mycheckbox.type = "checkbox";
    mycheckbox.id = "mycheckbox";

    var tbody = document.getElementById('tbody');
    var tr = document.createElement('tr');
    var td0 = document.createElement('td'); td0.innerHTML = mycheckbox.outerHTML;
    var td1 = document.createElement('td'); td1.innerHTML = author;
    var td2 = document.createElement('td'); td2.innerHTML = text;
    var td3 = document.createElement('td'); td3.innerHTML = time;

    tr.appendChild(td0);
    tr.appendChild(td1);
    tr.appendChild(td2);
    tr.appendChild(td3); 
    tbody.appendChild(tr); 
    tr.scrollIntoView();
    
    taskList.push(theTask(author, text, time));
    store(taskList);
}


function rename(){
    if (userName!="") {

        do{
            var newName = prompt("Write new name:", userName);
        }while(newName == null || newName == "")
        
        var table = document.getElementById('tbody');
        var length = table.querySelectorAll('tr').length;
        
        for (var i=0; i < length; i++) {
            if(table.rows[i].cells[1].textContent == userName){
                table.rows[i].cells[1].textContent = newName;
                taskList[i].author = newName;
            }
        };
        
        store(taskList);

        userName = newName;
        document.getElementById('welcome').textContent = "Welcome, " + userName;
    }else{
        alert("You must login!!");
    }
}

function deleteMessage(){
    if (userName!="") {
        var table = document.getElementById('tbody');
        var length = table.querySelectorAll('tr').length;

        for (var i=0; i < length; i++) {
            if(table.rows[i].cells[0].children[0].checked){
                if (userName == table.rows[i].cells[1].textContent) {
                    table.deleteRow(i);
                    i--;
                    length--;
                    taskList.splice(i + 1, 1);
                }else{
                    table.rows[i].cells[0].children[0].checked = false;
                    alert("You want delete another's message!! Access denied!!");
                }   
            }
        };
        store(taskList);
    }else{
        alert("You must login!!");
    }
}

function markAll(){
    var table = document.getElementById('messageTable');
    var galki = table.querySelectorAll('input');
    var length = galki.length;
    
    for (var i=0; i < length; i++) {
        galki[i].checked = true;
    };
}

function overwriteMessage(){
    if (userName!="") {

        var table = document.getElementById('tbody');
        var length = table.querySelectorAll('tr').length;
        
        for (var i=0; i < length; i++) {
            if(table.rows[i].cells[0].children[0].checked){
                table.rows[i].cells[0].children[0].checked = false;
                if (userName == table.rows[i].cells[1].textContent) {
                    table.rows[i].cells[2].textContent = prompt("Overwrite your message", table.rows[i].cells[2].textContent);
                    taskList[i].message = table.rows[i].cells[2].textContent;
                }else{
                    alert("You want overwrite another's message!! Access denied!!");
                }   
            }
        }

        store(taskList);
    
    }else{
        alert("You must login!!");
        document.getElementById('usermsg').value = "";
    }
}

var theTask = function(authorname, text, mestime) {
    return {
        author: authorname,
        message: text,
        time :mestime,
        id: guid()
    };
};
  
function run(){
    var allTasks = restore(); 
    createAllTasks(allTasks);
}

function createAllTasks(allTasks) {
    for(var i = 0; i < allTasks.length; i++)
        sendWithParams(allTasks[i].author, allTasks[i].message, allTasks[i].time);
}

function restore() {
    if(typeof(Storage) == "undefined") {
        alert('localStorage is not accessible');
        return;
    }
 
    var item = localStorage.getItem("taskList");
 
    return item && JSON.parse(item);
}
 
function store(listToSave) {
 
    if(typeof(Storage) == "undefined") {
        alert('localStorage is not accessible');
        return;
    }
 
    localStorage.setItem("taskList", JSON.stringify(listToSave));
}
 


//audio (not used)

function voice(text) {
    var audio = document.getElementById('audio');
    var url = 'https://tts.voicetech.yandex.net/generate?'+
    'key=917a18e8-ece3-4fe6-b9fa-d86397748a63' +
    '&text=' + encodeURI(text) +
    '&fornat=wav'+
    '&lang=ru-RU'+
    '&speaker=zahar'+
    '&emotion=evil';

    audio.src = url;
    audio.load();
}

function playMusic() {
    var audio = document.getElementById('audio');
    audio.play();
}

function voiceMessage(){
    var str = "";

    if (userName!="") {

        var table = document.getElementById('messageTable');
        var length = table.querySelectorAll('tr').length;
        var galki = table.querySelectorAll('input');

        for (var i=0; i < length - 1; i++) {
            if(galki[i].checked){
                str +=table.rows[i+1].cells[1].textContent;
                str + " ";
                galki[i].checked = false;
            }
        }
         voice(str);

    } else {
        alert("You must login!!");
        document.getElementById('usermsg').value = "";
    }
}