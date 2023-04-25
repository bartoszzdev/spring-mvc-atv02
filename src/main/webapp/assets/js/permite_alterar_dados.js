// liberar alteração nos campos do formulário 
const btnAlterar = document.querySelector('#alterar');
const meuForm = document.querySelectorAll('input, select, date, button');
btnAlterar.addEventListener('click', () => {
    meuForm.forEach((campo) => {
        campo.removeAttribute('disabled');
    })
    meuForm[0].focus();
});