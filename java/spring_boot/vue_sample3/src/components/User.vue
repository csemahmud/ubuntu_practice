<template>
    <div class="container" style="margin: 2em">
        <h1 class="text-center">Users List</h1>
        <table class="table table-striped">
            <thead>
            <tr>
                <th>Id</th>
                <th>Name</th>
                <th>Email</th>
                <th>Domain</th>
                <th>Age</th>
                <th>Experience</th>
                <th>Salary</th>
            </tr>
            </thead>
            <tbody>
                <tr v-for="user in users" v-bind:key = "user.id">
                    <td>{{user.id}}</td>
                    <td>{{user.name}}</td>
                    <td>{{user.email}}</td>
                    <td>{{user.domain}}</td>
                    <td>{{user.age}}</td>
                    <td>{{user.experience}}</td>
                    <td>{{user.salary}}</td>
                </tr>
            </tbody>
        </table>
    </div>
</template>

<script>
import UserService from '../services/UserService'
export default {
    name: 'Users',
    data(){
        return {
            users : []
        }
    },
    methods: {
        getUsers(){
            UserService.getUsers().then((response) => {
                this.users = response.data;
            });
        }
    },
    created(){
        this.getUsers()
    }
}

</script>

<style>
    table {
    min-width: 100px;
    white-space: nowrap;
    margin: 0px;
    border-collapse: collapse;
    }

    table thead tr th {
    border-color: #007;
    border-width: 3px;
    border-collapse: collapse;
    border-style: solid;
    margin: 0px;
    padding: 5px;
    white-space: nowrap;
    }

    table tbody tr td {
    border-color: #007;
    border-width: 3px;
    border-collapse: collapse;
    border-style: solid;
    margin: 0px;
    padding: 5px;
    white-space: nowrap;
    }

    table thead{
    background-color: #77f;
    color: #007;
    text-align: center;
    font-weight: bold;
    }

    table tbody{
    text-align: left;
    }
</style>
