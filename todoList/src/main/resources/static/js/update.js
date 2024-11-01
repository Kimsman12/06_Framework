const submitBtn = document.querySelector(".btn")

submitBtn.addEventListener("click", () => {

  location.href="/todo/update?todoNo="+todoNo;

});



