<template>

    <v-data-table
        :headers="headers"
        :items="productseach"
        :items-per-page="5"
        class="elevation-1"
    ></v-data-table>

</template>

<script>
    const axios = require('axios').default;

    export default {
        name: 'ProductseachView',
        props: {
            value: Object,
            editMode: Boolean,
            isNew: Boolean
        },
        data: () => ({
            headers: [
                { text: "id", value: "id" },
            ],
            productseach : [],
        }),
          async created() {
            var temp = await axios.get(axios.fixUrl('/productseaches'))

            temp.data._embedded.productseaches.map(obj => obj.id=obj._links.self.href.split("/")[obj._links.self.href.split("/").length - 1])

            this.productseach = temp.data._embedded.productseaches;
        },
        methods: {
        }
    }
</script>

