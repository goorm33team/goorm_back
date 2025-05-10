window.onload = function () {
    fetch('/companies') // API로 회사 목록 요청
        .then(res => res.json())
        .then(data => {
            const container = document.getElementById('company-list');
            data.forEach(company => {
                const card = document.createElement('div');
                card.className = 'company-card';
                card.innerHTML = `
                    <strong>${company.name} 직무공고</strong>
                    <p>${company.industry || "설명 없음"}</p>
                    <small>${company.location}</small>
                    <!-- <small>${company.location} · 경력(년수)</small> -->
                `;
                card.onclick = () => {
                                    window.location.href = 'job-list.html?companyId=' + company.id;
                };
                container.appendChild(card);
            });
        });
};

function goToRegister() {
    location.href = '/register-job.html'; // 등록 페이지로 이동
}