// 사이드바를 토글하는 함수
function toggleSidebar() {
    const sidebar = document.getElementById('sidebar');
    sidebar.classList.toggle('open');
}

function filterMenu(category) {
    const items = document.querySelectorAll('.menu-item');
    const buttons = document.querySelectorAll('.menu-category-bar button');

    // 모든 버튼의 active 클래스 제거
    buttons.forEach(button => button.classList.remove('active'));

    // 클릭한 버튼에 active 클래스 추가
    const activeButton = document.querySelector(`.menu-category-bar button[onclick="filterMenu('${category}')"]`);
    activeButton.classList.add('active');

    // 필터링
    items.forEach(item => {
        if (category === 'all') {
            item.style.display = 'block';
        } else {
            item.style.display = item.classList.contains(category) ? 'block' : 'none';
        }
    });
}
