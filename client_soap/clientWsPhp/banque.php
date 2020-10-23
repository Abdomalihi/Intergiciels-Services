<?php
	$mnt=0;
	if(isset($_POST['action'])){
        $clientSOAP = new SoapClient("http://localhost:1992/BanqueWS?wsdl");
        if($_POST['action']=="OK") {
            $mnt = $_POST['montant'];
            $param = new stdClass();
            $param->montant=$mnt;
            $res = $clientSOAP->__soapCall("conversionEuroToDhs",array($param));
        }elseif ($_POST['action']=="Comptes"){
            $comptes = $clientSOAP->__soapCall("getComptes",array());
        }
    }
?>
<!DOCTYPE html>
<html>
<head>
	<title></title>
	<link rel="stylesheet" type="text/css" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container p-3">
        <form class="form-inline" action="banque.php" method="POST">
            <div class="form-group mb-2">
                <label for="montant">Montant = </label>
                <input type="text" id="montant" class="form-control" name="montant" value="<?=$mnt?>" required>
            </div>
            <input type="submit" name="action" value="OK" class="btn btn-primary mb-2 ml-2">
            <input type="submit" name="action" value="Comptes" class="btn btn-warning mb-2 ml-2">
        </form>
        <?php if (isset($_POST['action'])): ?>
            <?php if (!empty($res)): ?>
                <div class="alert alert-success m-4 text-center" role="alert">
                    <?=$mnt?>  en Euro = <?=$res->return?> en Dhs
                </div>
            <?php endif; ?>
            <?php if (!empty($comptes)): ?>
                <table class="table table-striped">
                    <thead>
                        <tr>
                            <th scope="col">Code</th>
                            <th scope="col">Solde</th>
                        </tr>
                    </thead>
                    <tbody>
                    <?php foreach ($comptes->return as &$value): ?>
                        <tr>
                            <th scope="row"><?=$value->code?></th>
                            <td><?=$value->solde?></td>
                        </tr>
                    <?php endforeach; ?>
                    </tbody>
                </table>
            <?php endif; ?>
        <?php endif; ?>
	</div>
</body>
</html>