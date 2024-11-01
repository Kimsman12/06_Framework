const todoTitle = document.querySelector("#todoTitle");
const addForm = document.querySelector("#updateForm");
const todoContent = document.querySelector("#todoContent");
const addBtn = document.querySelector("#addBtn");

addBtn.addEventListener("click", e => {

  const inputTitle = todoTitle.value.trim();
  const inputContent = todoContent.value.trim();

  if(inputTitle.length === 0) {
    e.preventDefault();
    alert("제목을 입력해 주세요");
    todoTitle.focus();
    return;
  }

  if(inputContent.length === 0) {
    e.preventDefault();
    alert("내용을 작성해 주세요");
    todoContent.focus();
    return;
  }

})
