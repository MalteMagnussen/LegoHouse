<!-- Author: Malte -->
<!--  Below is the Table for a Bill of Materials  -->
<table border="3" width="2" cellspacing="2" cellpadding="2" class="table">

    <thead class="thead-dark table-bordered table-hover table-sm">
        <tr>
            <th scope="col">Type</th>
            <th scope="col">Side m. dør.</th>
            <th scope="col">Bredside</th>
            <th scope="col">Side m. vindue</th>
            <th scope="col">Bredside</th>
            <th scope="col">ialt</th>
        </tr>
    </thead>

    <tbody>

        <tr>
            <td scope="row"> 2x4 </td>
            <td>${BOM.door.fours}</td>
            <td>${BOM.wide.fours}</td>
            <td>${BOM.window.fours}</td>
            <td>${BOM.wide.fours}</td>
            <td>${BOM.totalfours}</td>
        </tr>

        <tr>
            <td scope="row"> 2x2 </td>
            <td>${BOM.door.twos}</td>
            <td>${BOM.wide.twos}</td>
            <td>${BOM.window.twos}</td>
            <td>${BOM.wide.twos}</td>
            <td>${BOM.totaltwos}</td>
        </tr>

        <tr>
            <td scope="row"> 2x1 </td>
            <td>${BOM.door.ones}</td>
            <td>${BOM.wide.ones}</td>
            <td>${BOM.window.ones}</td>
            <td>${BOM.wide.ones}</td>
            <td>${BOM.totalones}</td>
        </tr>

    </tbody>

</table>