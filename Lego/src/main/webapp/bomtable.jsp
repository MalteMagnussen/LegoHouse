<!-- Author: Malte -->
<!--  Below is the Table for a Bill of Materials  -->
<table border="3" width="2" cellspacing="2" cellpadding="2" class="table table-bordered table-hover">

    <thead class="thead-dark">
        <tr>
            <th scope="col">Type</th>
            <th scope="col">Side w. door</th>
            <th scope="col">Wideside</th>
            <th scope="col">Side w. window</th>
            <th scope="col">Wideside</th>
            <th scope="col">Total</th>
        </tr>
    </thead>

    <tbody>

        <tr>
            <th scope="row"> 2x4 </th>
            <td>${BOM.door.fours}</td>
            <td>${BOM.wide.fours}</td>
            <td>${BOM.window.fours}</td>
            <td>${BOM.wide.fours}</td>
            <td>${BOM.totalfours}</td>
        </tr>

        <tr>
            <th scope="row"> 2x2 </th>
            <td>${BOM.door.twos}</td>
            <td>${BOM.wide.twos}</td>
            <td>${BOM.window.twos}</td>
            <td>${BOM.wide.twos}</td>
            <td>${BOM.totaltwos}</td>
        </tr>

        <tr>
            <th scope="row"> 2x1 </th>
            <td>${BOM.door.ones}</td>
            <td>${BOM.wide.ones}</td>
            <td>${BOM.window.ones}</td>
            <td>${BOM.wide.ones}</td>
            <td>${BOM.totalones}</td>
        </tr>

    </tbody>

</table>