document.addEventListener("DOMContentLoaded", () => {
    const urlParams = new URLSearchParams(window.location.search);
    const companyId = urlParams.get("id");

    fetch(`/companies/${companyId}`) // 백엔드에서 회사 + 직무목록 응답
        .then(response => response.json())
        .then(data => {
            const { name, location, industry, jobs } = data;

            // 회사 정보 출력
            document.getElementById("companyInfo").innerHTML = `
        <h2>${name}</h2>
        <p>${location} / ${industry}</p>
      `;

            // 직무 목록 출력
            const jobList = document.getElementById("jobList");
            jobs.forEach(job => {
                const jobDiv = document.createElement("div");
                jobDiv.classList.add("job-item");
                jobDiv.innerHTML = `
          <div class="job-description">${job.description}</div>
          <div class="job-detail">${job.career} · ${job.salary} · ${job.skill}</div>
        `;
                jobList.appendChild(jobDiv);
            });
        })
        .catch(error => {
            console.error("에러 발생:", error);
        });
});