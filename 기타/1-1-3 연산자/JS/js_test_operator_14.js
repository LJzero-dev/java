var isOnNotebook = true;

// if (!isOnNotebook) { // 노트북이 isOn이 아니라면.. 꺼져 있다면.. code의 리딩시 ! 많이 사용됩니다.
//     console.log("Notebook is Off");
// } else {
//     console.log("Notebook is ON");
// }
// 부연 설명
if (!isOnNotebook) { // 노트북이 isOn이 아니라면.. 꺼져 있다면.. code의 리딩시 ! 많이 사용됩니다.
    console.log("Notebook is Off");
} else {
    console.log("Notebook is ON");
}

// 위의 if (!isOnNotebook)는 아래와 같이 풀어 쓸 수 있습니다. 같은 의미 입니다.
if (isOnNotebook == false) {
    console.log("NotebookEx is Off");
} else {
    console.log("NotebookEx is ON");
}
///////////////////////////////////////////////////////
if (isOnNotebook) {
    console.log("Notebook 03 is ON");
} else {
    console.log("Notebook 03 is Off");
}

// 위의 if (isOnNotebook)은 아래와 같이 풀어 쓸 수 있습니다. 같은 의미 입니다.
if (isOnNotebook == true) {
    console.log("Notebook 04 is ON");
} else {
    console.log("Notebook 04 is Off");
}