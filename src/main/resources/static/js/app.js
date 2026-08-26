document.addEventListener('click', function (event) {
    if (!event.target.closest('.data-confirm')) {
        return;
    }
    if (!window.confirm('Czy na pewno?')) {
        event.preventDefault();
    }
});
