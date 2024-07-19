function updateImagePreview() {
            const coverImageUrl = document.getElementById("coverImageUrl").value;
            const coverImagePreview = document.getElementById("coverImagePreview");

            if (coverImageUrl) {
                const img = new Image();
                img.crossOrigin = "Anonymous"; // Para permitir o redimensionamento de imagens de URLs externas
                img.onload = () => {
                    const pica = window.pica();
                    const canvas = document.createElement('canvas');
                    canvas.width = 200; // Largura fixa
                    canvas.height = (img.height / img.width) * 200; // Altura proporcional

                    pica.resize(img, canvas)
                        .then(result => {
                            coverImagePreview.src = result.toDataURL();
                        });
                };
                img.src = coverImageUrl;
            } else {
                coverImagePreview.src = "";
            }
        }