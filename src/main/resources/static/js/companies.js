window.onload = function () {
    fetch('/api/companies') 
        .then(res => res.json())
        .then(data => {
            const container = document.getElementById('company-container');
            data.forEach(company => {
                const card = document.createElement('div');
                card.className = 'company-item';
                card.innerHTML = `
          <div class="company-logo"></div>
          <div class="company-name">${company.name}</div>
        `;
                container.appendChild(card);
            });
        });
};
