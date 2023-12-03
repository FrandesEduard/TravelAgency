$(document).ready(() => {

    let idOfOfferToEdit;

    $('#add-button-modal').click(() => {
        const name = $('#modal-name').val();
        const destination = $('#modal-destination').val();
        const price = $('#modal-price').val();
        const lengthOfStay = $('#modal-lengthOfStay').val();

        const newOffer = {
            name: name,
            destination: destination,
            price: price,
            lengthOfStay: lengthOfStay
        };

        if (idOfOfferToEdit == null) {
            addOffer(newOffer);
        } else {
            editOffer(idOfOfferToEdit, newOffer);
        }
    });

    $('.delete-icon').click(function () {
        const offerId = this.parentElement.id;

        fetch('offers/' + offerId, {
            method: 'DELETE'
        }).then(response => location.reload());
    });

    $('.edit-icon').click(function () {
        idOfOfferToEdit = this.parentElement.id;
        const row = this.parentElement.parentElement;
        const name = row.children[0].innerText;
        const destination = row.children[1].innerText;
        const price = row.children[2].innerText;
        const lengthOfStay = row.children[3].innerText;

        $('#modal-name').val(name);
        $('#modal-destination').val(destination);
        $('#modal-price').val(price);
        $('#modal-lengthOfStay').val(lengthOfStay);
    })

    function addOffer(newOffer) {
        fetch('offers', {
            method: 'POST',
            body: JSON.stringify(newOffer),
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(response => {
            if (response.ok) {
                location.reload();
            } else {
                alert("There are errors " + response.status);
            }
        });
    }

    function editOffer(idOfOfferToEdit, newOffer) {
        fetch('offers/' + idOfOfferToEdit, {
            method: 'PUT',
            body: JSON.stringify(newOffer),
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(response => {
            if (response.ok) {
                location.reload();
            } else {
                alert("There are errors" + response.status);
            }
        });
    };

    $('#add-offer-button').click(function () {
        $('#modal-name').val('');
        $('#modal-destination').val('');
        $('#modal-price').val('');
        $('#modal-lengthOfStay').val('');
    })
})
