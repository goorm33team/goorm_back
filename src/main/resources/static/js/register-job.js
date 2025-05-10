function goToJobForm() {
    const name = document.getElementById('companyName').value;
    const location = document.getElementById('location').value;
    const industry = document.getElementById('industry').value;

    fetch('/companies', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ name, location, industry })
    })
        .then(res => res.json())
        .then(company => {
            // 회사 select에 하나만 추가하고 다음 페이지로
            const select = document.getElementById('companySelect');
            select.innerHTML = `<option value="${company.id}">${company.name}</option>`;
            document.getElementById('company-form').style.display = 'none';
            document.getElementById('job-form').style.display = 'block';
        })
        .catch(err => alert('회사 등록 실패: ' + err));
}

function submitJob() {
    const companyId = document.getElementById('companySelect').value;
    const career = document.getElementById('career').value;
    const salary = document.getElementById('salary').value;
    const description = document.getElementById('description').value;
    const skill = document.getElementById('skill').value;

    fetch(`/companies/${companyId}/jobs`, {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ career, description, salary, skill })
    })
        .then(res => {
            if (!res.ok) throw new Error('직무 등록 실패');
            // 응답이 비어있을 수도 있으므로 처리
            return res.text();
        })
        .then(() => {
            alert('직무 등록 완료!');
            window.location.href = '/';
        })
        .catch(err => {
            console.error("직무 등록 실패:", err);
            alert('직무 등록 실패: ' + err.message);
        });

}