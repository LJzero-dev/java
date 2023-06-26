var cat = {
  name: "bbomi",
  age: 2,
  color: "black"
};

function init() {
  console.log("init function is ok");
  objectSend(cat);
  var okButton=document.getElementById("ok_button");
  okButton.onclick=click;
}

function objectSend(obj) {
  if (obj.age > 1) {
      console.log("cat is adult");
  } else {
      console.log("cat is kid");
  }
  console.log(cat.name);
  console.log(cat.color);
}

function click(){
  objectSend(cat);
}

window.onload = init;