const submitBtn = document.querySelector(".btn");
const todoTitle = document.querySelector("#todoTitle");
const addForm = document.querySelector("#updateForm");
const todoContent = document.querySelector("#todoContent");

addForm.addEventListener("submit", e => {

  const inputTitle = todoTitle.value.trim();
  const inputContent = todoContent.value.trim();

  if(inputTitle.length===0){
    e.preventDefault();
    alert("제목을 입력해 주세요");
    todoTitle.focus();

    return;
  } 
  if (inputContent.length===0){
    e.preventDefault();
    alert("내용을 입력해 주세요");
    todoContent.focus();
    
    return;
  }

});



