document.addEventListener("DOMContentLoaded", function() {
    const navLinks = document.querySelectorAll('nav ul li a');

    navLinks.forEach(link => {
        link.addEventListener('click', function(event) {
            event.preventDefault(); 
            const pageName = this.textContent.toLowerCase().replace(/\s+/g, ''); // Get page name from link text

            switch(pageName) {
                case 'purchasebooks':
                    window.location.href = 'Purchased.html'; // Replace with actual page URL
                    break;
                case 'availablebooks':
                    window.location.href = 'AvailableBooks.html'; // Replace with actual page URL
                    break;
                case 'logout':
                    // Add your logout logic here, e.g., clearing session data
                    window.location.href = 'index.html'; // Redirect to login page
                    break;
                default:
                    break;
            }
        });
    });
});
