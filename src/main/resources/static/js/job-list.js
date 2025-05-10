window.onload = function () {
    const params = new URLSearchParams(location.search);
    const companyId = params.get('companyId');

    if (!companyId) {
        alert("companyId가 없습니다.");
        return;
    }

    fetch(`/companies/${companyId}/jobs`)
        .then(res => res.json())
        .then(data => {
            console.log("받아온 직무 데이터:", data); // 🔍 디버깅용
            const container = document.getElementById("job-list-container");
            container.innerHTML = ""; // 초기화

            if (!Array.isArray(data) || data.length === 0) {
                container.innerHTML = "<p>등록된 직무가 없습니다.</p>";
                return;
            }

            data.forEach(job => {
                const description = job.description || "(설명 없음)";
                const career = job.career !== null ? job.career + "년차" : "경력 정보 없음";
                const salary = job.salary ? job.salary + "만원" : "연봉 정보 없음";
                const skill = job.skill || "없음";

                const card = document.createElement("div");
                card.className = "job-card";
                card.innerHTML = `
                    <h3 class="job-description">${description}</h3>
                    <p class="job-career"><strong>경력:</strong> ${career}</p>
                    <p class="job-salary"><strong>연봉:</strong> ${salary}</p>
                    <p class="job-skill"><strong>우대사항:</strong> ${skill}</p>
                `;
                container.appendChild(card);
            });
        })
        .catch(error => {
            console.error("직무 데이터를 불러오는 중 오류 발생:", error);
        });
};
