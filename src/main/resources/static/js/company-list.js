window.onload = function () {
    fetch('/companies')
        .then(res => res.json())
        .then(data => {
            const container = document.getElementById('company-list-container');
            data.forEach(company => {
                const card = document.createElement('div');
                card.className = 'company-item';
                card.innerHTML = `
                    <div class="company-logo"></div>
                    <div class="company-name">${company.name}</div>
                `;
                card.onclick = () => {
                    window.location.href = 'job-list.html?companyId=' + company.id;
                };
                container.appendChild(card);
            });
        });
};
