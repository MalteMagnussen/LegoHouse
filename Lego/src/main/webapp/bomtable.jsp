<script>
    $(document).ready(function () {
        $('#order').DataTable();
    });
</script>
<!--  Below is the Table for a Bill of Materials  -->
<table border="3" width="2" cellspacing="2" cellpadding="2" id="order" class="display">

    <thead>
        <tr>
            <th>Type</th>
            <th>Side m. dør.</th>
            <th>Bredside</th>
            <th>Side m. vindue</th>
            <th>Bredside</th>
            <th>ialt</th>
        </tr>
    </thead>

    <tbody>

        <tr>
            <td> 2x4 </td>
            <td>${BOM.door.fours}</td>
            <td>${BOM.wide.fours}</td>
            <td>${BOM.window.fours}</td>
            <td>${BOM.wide.fours}</td>
            <td>${BOM.totalfours}</td>
        </tr>

        <tr>
            <td> 2x2 </td>
            <td>${BOM.door.twos}</td>
            <td>${BOM.wide.twos}</td>
            <td>${BOM.window.twos}</td>
            <td>${BOM.wide.twos}</td>
            <td>${BOM.totaltwos}</td>
        </tr>

        <tr>
            <td> 1x2 </td>
            <td>${BOM.door.ones}</td>
            <td>${BOM.wide.ones}</td>
            <td>${BOM.window.ones}</td>
            <td>${BOM.wide.ones}</td>
            <td>${BOM.totalones}</td>
        </tr>

    </tbody>

</table>